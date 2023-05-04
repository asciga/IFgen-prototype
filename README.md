# ifgen

Clojure code that extends an implementation of a story generator from: Tate, Bruce, et al. Seven more languages in seven weeks: Languages that are shaping the future. Pragmatic Bookshelf, 2014.

Code has been optimized and extended to handle multiple inputs and outputs for story events.

## Usage

IFgen requires a manually authored potential narrative to function, this is loaded as story_elements in the code and comes with an example.

Using a terminal open up the project using
    lein repl

Then to generate a story use the following format:
    (with-db story/story-db
    (run 1 [q]
    (story/storyo [:start] [:end] q)))

Where [:start] and [:end] are your starting state and desired goal state.


## License
Copyright © 2014 The Pragmatic Programmers, LLC.
Used with permission.