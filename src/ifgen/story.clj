;;IFgen requires a manually authored potential narrative to function, this is loaded as story_elements in the code and comes with an example.

;;Using a terminal open up the project using
;;    lein repl

;;Then to generate a story use the following format:
;;    (with-db story/story-db
;;    (run 1 [q]
;;    (story/storyo [:start] [:end] q)))

;;Where [:start] and [:end] are your starting state and desired goal state.


(ns ifgen.story)
(use 'clojure.core.logic)
(use 'clojure.core.logic.pldb)
(require '[ifgen.story :as story])
(load "story_elements")


;;this prototype is heavily based on Chris Martens work as well as a Pragmatic Programmers clojure core.logic tutorial on generation

;;database relation of story element input a to output b 
(db-rel ploto a b)  

;;this function is used to turn our database of story elements into a database of facts for core.logic
(def story-db 
    (reduce (fn [dbase elems] ;; we can use a reduce function to crunch the story elements, our accumulator is the database elems
        (apply db-fact dbase ploto (take 2 elems))) ;;we add a new fact to elems using the ploto relation first 2 elements, first is consumed second is produced
        (db) ;;initial state is blanko
        story-elements)) ;;do this for the entire story-elements vector database into a database of facts for core.logic

;;start state of the story
;;(def start-state
;;    [:start])

;;new function to iterate through our list and run a goal
(defn for-all [goal lst]
  (conde
   [(== lst ())]
   [(fresh [fst rst]
      (conso fst rst lst)
      (goal fst)
      (for-all goal rst))]))

;;recursion to remove a list of inputs from the world state
(defn rembero-all [lst state temp] 
    (conde
    [(== lst ())
     (== state temp)]
    [(fresh [fst rst rectemp]
        (conso fst rst lst)
        (rembero fst state temp)
        (rembero-all rst temp rectemp))]))

;;function to find an action, consume the elements and produce new story states
(defn actiono [state new-state action] 
    (fresh [in out temp]
        (ploto in out)
        (for-all #(membero % state) in)
        (rembero-all in state temp)
        (appendo out temp new-state)
            (== action [in out])))

;;now to generate a story we want to start at our goal state  and work backwards to see what actions would need to happen
(declare storyo*)

;;this is what we call, storyo with a starting list of elems,  an ending list
(defn storyo [start-state end-elems actions]
    (storyo* (shuffle start-state) end-elems actions)) ;;storyo* uses a shuffled hardcoded initial state to get randomized sequences

(defn storyo* [start-state end-elems actions]      ;;define story*
    (fresh [action new-state new-actions]          ;;define new unbound logic variables
    (actiono start-state new-state action)         ;;use some action to get to a new state
    (conso action new-actions actions)             ;;add that action to a list so we can keep track of the sequence of events
    (conda                                         ;;conda only returns from the first successful branch
        [(everyg #(membero % new-state) end-elems)     ;;first branch: everyg only succeeds if everything in goal function does, so when story fits goal elements
        (== new-actions [])]                           ;;no more actions once story is completed
        [(storyo* new-state end-elems new-actions)]))) ;;if the story isn't complete we recurse this function to keep looking