(in-ns 'ifgen.story)

(def story-elements

[[[:start] [:dessertwithwife :babyclothesdahlia :bedroomlight]
"You get back to the apartment early. Your wife walks in and speaks with you. You settle in to eat dessert, she tells you she's pregnant and shows you some baby clothes she bought with Dahlia written on them"]

[[:dessertwithwife] [:coparrives]
"A cop arrives and arrests both of you, you are knocked unconscious."]

[[:coparrives] [:loopone]
"Time resets to the point you got home"]

[[:loopone] [:hideincloset]
"You hide in the closet for this loop and wait to see what will happen when the cop arrives."]

[[:hideincloset] [:looptwo :pocketwatch]
"While hiding in the closet you learn the cop is looking for a pocket watch that your wife has hidden in a vent in the bathroom, and that he claims she killed her father."]

[[:looptwo :pocketwatch ] [:wifestormsout]
" You grab the pocket watch from under the sink but your wife storms out of the apartment when she see's what you're doing."]

[[:wifestormsout ] [:loopthree :pocketwatch]
"You follow your wife out of the apartment and the loop resets as soon as you leave."]

[[:loopthree :pocketwatch :babyclothesdahlia] [:convincewifeofloop]
" You show your wife where the pocket watch is hidden, and what the hidden babyclothes have written on them. You convince her you're in a time loop."]

[[:convincewifeofloop] [:wifekilledfather :polaroid]
" Once you convince her she says that she shot her father after an argument with him, and she ran away that same day. A polaroid on the fridge shows her on Christmas day after she ran away"]

[[:wifekilledfather ] [:loopfour ]
"After learning of this the cop arrives and knocks you unconscious. "]

[[:bedroomlight :loopfour] [:bedroomlightbroken :loopfive]
"You learn the bedroom light will electrocute you if you turn it on then off then on again."]

[[:loopfive] [:sleepingpills :wifeasleep]
"You find some sleeping pills and you add them to your wife's water before she drinks it. She goes to the bedroom and falls asleep"]

[[:wifeasleep ] [:coparrives]
"The cop arrives and zipties you before shooting your wife while she is asleep."]

[[:wifeasleep ] [:loopsix]
"You walk out of the apartment and reset the time loop."]

[[:loopsix :bedroomlightbroken :sleepingpills] [:copziptied :copdaughterphonenumber]
"You turn the bedroom light on and give the sleeping pills to your wife so that she will go to the bedroom, turn the light off and fall asleep while you hide in the closet and wait. The cop arrives and electrocutes himself on the bedroom light, where you ziptie him and take his phone, learning that his duaghter has an illness he can't afford the treatments for."]

[[:copziptied] [:loopseven]
"Eventually after 12 minutes the loop resets on its own, however know you know the cop's daughters phone number."]

[[:loopseven :polaroid] [:coparrives :polaroid]
"You try to convince the cop using the polaroid that your wife couldn't have killed her father because she wasn't there at the time of his death. He doesn't listen and knocks you unconscious."]

[[:copdaughterphonenumber] [:dancewithwife :copdaughterphonenumber :loopeight]
"You call the cop's daughter and tell her that her father is trying to kill your wife and take the pocket watch to pay for her treatments. The cop doesn't arrive and you enjoy a dance with your wife, however after 12 minutes the loop resets."]

[[:loopeight :copdaughterphonenumber :polaroid] [:convincecop :nannydahlia]
"You call the cop's daughter and tell her to call him and tell him to listen to you when he arrives. You then use the polaroid to convince him that your wife didn't kill her father, but her half-brother did. Her half-brother's mom was the nanny who's name started with a D-"]

[[:convincecop] [:loopnine]
"Before he can finish the nanny's name, the loop resets."]

[[:loopnine :nannydahlia :babyclothesdahlia] [:ending]
"You call the cop's daughter again, convincing him to listen. You use the polaroid to convince him your wife didn't kill her father, and when the nanny is brought up you show him the baby clothes with her name on it: Dahlia. Your wife gives him the pocket watch and he leaves."]])

