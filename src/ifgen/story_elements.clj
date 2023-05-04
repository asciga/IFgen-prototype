;;Here is where the relations are coded, they take the following format:
;;[[:input] [:output]
;;"Text description"]

(in-ns 'ifgen.story)

(def story-elements

[[[:start] [:OrdinaryWorld] 
"Start generating Act 1."]

;;Act 1 Ordinary World
[[:OrdinaryWorld] [:SpaceshipMission :CalltoAdventure]
"In a sci-fi world a spaceship with a capable crew is restocking supplies."]

;;Act 1 Calls to Adventure
[[:CalltoAdventure] [:StrangeReadings :Refusal]
"Picked up strange readings in a solar system "]

[[:CalltoAdventure] [:DistressCall :Refusal]
"Picked up a Distress Call in a system "]

[[:CalltoAdventure] [:TransportingCargo :Refusal]
"Tasked with transporting Cargo"]

[[:CalltoAdventure] [:FerryingPassengers :Refusal]
"Tasked with ferrying passengers."]

;;Act 1 Refusing the call, motivations
[[:Refusal] [:MotivatedbyMoney :MeetingMentor]
"Doesn't want to go but needs the money."]

[[:Refusal] [:AfraidofAdventure :MeetingMentor]
"Afraid of what might happen on the journey."]

[[:Refusal] [:NotAbandonFamily :MeetingMentor]
"Afraid of leaving family and friends."]

[[:Refusal] [:NoRefusal :MeetingMentor]
"The character does not refuse the call."]

;;Act 1 Mentors
[[:MeetingMentor] [:OldFriend :CrossingThreshold]
"And old friend sends a message."]

[[:MeetingMentor] [:Expert :CrossingThreshold]
"An expert is assigned to travel with the hero."]

[[:MeetingMentor] [:MysteriousBenefactor :CrossingThreshold]
"A mysterious benefactor contacts the hero."]

[[:MeetingMentor] [:Starmaps :CrossingThreshold]
"The hero consults old navigation charts to find their way."]

[[:MeetingMentor] [:NoMentor :CrossingThreshold]
"The hero consults old navigation charts to find their way."]

;;Act 1 Crossing The Threshold
[[:CrossingThreshold] [:JourneyBegins :Test :Ally :Enemy]
"The spaceship sets off on its journey."]

[[:CrossingThreshold] [:ShipMalfunction :Test :Ally :Enemy]
"The spaceship sets off on its journey and immediately has some malfunctions to be fixed"]

[[:CrossingThreshold] [:Deadline :Test :Ally :Enemy]
"The deadline has been moved up and the spaceship must depart now."]

[[:CrossingThreshold :TransportingCargo] [:AttemptToSteal :Test :Ally :Enemy]
"Someone has tried to steal the cargo, the hero has to go now!"]

;;Act 2 Tests, Allies, Enemies 

;;Pirate theme
[[:Test] [:SpacePirateAttack :SpacePirates ]
"The ship is attacked by SpacePirates"]

[[:Ally :MotivatedbyMoney :SpacePirates] [:AllyPirate :MotivatedbyMoney]
"Promising the pirates a cut of the profits, the hero convinces them to join their side."]

[[:Enemy :SpacePirates] [:EnemyPirate :Approach]
"A large crew of space pirates is gunning for the hero."]

;;Rogue AI theme
[[:Test :Deadline] [:UnchartedSpace :Deadline ]
"With the deadline coming up so quickly the hero must take drastic action. They pilot their ship into uncharted space"]

[[:Test :DistressCall] [:UnchartedSpace :DistressCall ]
"With the urgency of the DistressCall. They pilot their ship into uncharted space."]

[[:Enemy :StrangeReadings] [:EnemyRogueAI :StrangeReadings :Approach]
"Picking up a burst of the readings the hero was searching for, their ship is attacked by unmanned drones."]

[[:Enemy :UnchartedSpace] [:EnemyRogueAI :Approach]
"While flying through uncharted space, the ship is attacked by unmanned drones."]

[[:Ally :UnchartedSpace :MysteriousBenefactor] [:AllyRogueAI]
"An artificial intelligence reveals itself to be the mysterious benefactor, offering further assistance."]

[[:Ally :UnchartedSpace :Starmaps] [:AllyRogueAI]
"The hero encounters a rogue articial intelligence in uncharted space. After offering the starmaps to it, it is willing to help the hero find their way"]

;;BountyHunter Theme

[[:Test] [:BountyHunterAttack ]
"The hero must fight off a bounty hunter's ship."]

[[:Enemy :FerryingPassengers :BountyHunterAttack] [:EnemyBountyHunter :FerryingPassengers]
"One of the passengers is being hunted by a bounty hunter."]

[[:Enemy :BountyHunterAttack] [:EnemyBountyHunter :Approach]
"Someone has put a bounty on the hero's head and he is now being hunted."]

;;Other Allies
[[:Ally :ShipMalfunction :Expert] [:AllyExpert]
"The Expert assigned to the ship is able to repair the malfunctions, they are reliable!"]

[[:Ally] [:AllyCrew]
"At a spacestation the hero spends some time reinforcing bonds with the crew. They can count on them."]

;;Coming out of this section it's possible to have:
;; Tests: SpacePirateAttack, UnchartedSpace, BountyHunterAttack
;; Allies: AllyPirate, AllyRogueAI, AllyExpert, AllyCrew
;; Enemies: EnemyPirate, EnemyRogueAI, EnemyBountyHunter

;;Act 2 Approach to Inmost Cave

;;Basically all preparations that are done before the ordeal. Kinda based on ally/enemy
;;can also have a guardian.


;;Upgraded Ship

[[:Approach :AllyRogueAI] [:Approach :UpgradedShip :Ordeal]
"The friendly artificial intelligence upgrades the hero's ship, improving its capabilities."]

;;Asteroid Belt
[[:Approach :StrangeReadings] [:AsteroidBelt :Ordeal]
"The ship approaches the source of the strange readings somewhere in an asteroid belt."]

[[:Approach :DistressCall] [:AsteroidBelt :Ordeal]
"The ship approaches the source of the distress call, somewhere in an asteroid belt."]

;;Waiting to Dock
[[:Approach] [:WaitingToDock :Ordeal]
"Arriving at their destination, the ship waits to dock at a space station"]

;;Passenger goal

[[:WaitingToDock :FerryingPassengers] [:SpaceStation :FerryingPassengers]
"After some waiting the ship is accepted into the station and docks, unloading the passengers."]

[[:WaitingToDock :TransportingCargo] [:SpaceStation :TransportingCargo]
"After some waiting the ship is accepted into the station and docks unloading the cargo."]

;;Cargo goal
[[:WaitingToDock :TransportingCargo] [:IllegalCargo]
"A cargo scan flags the hero's ship as carrying illegal goods! They have to talk their way out of this one"]

[[:IllegalCargo :AllyPirate] [:AllyPirate :SpaceStation :TransportingCargo]
"Although the hero is refused entry to the station, their pirate friends find them a way to smuggle it on board."]

[[:IllegalCargo :NotAbandonFamily] [:NotAbandonFamily :SpaceStation :TransportingCargo]
"The hero gives a heartfelt speech to the docking authorities about their family back home, he needs this job done he doesn't know anything about the cargo."]

[[:IllegalCargo :AllyCrew] [:AllyCrew :SpaceStation :TransportingCargo]
"The crew of the ship show the hero a hidden smuggling compartment for the cargo that'll let them hide it and dock."]

;;approaches places: SpaceStation, AsteroidBelt

;;Act 2 Ordeal

;;Pirates attack station
[[:Ordeal :EnemyPirate :SpaceStation] [:PiratesAttackStation]
"While docked at the station it is attacked by a pirate armada!"]

[[:PiratesAttackStation :UpgradedShip] [:UpgradedShip :FoughtOffPirates :Reward]
"The hero valiantly uses their upgraded to ship to fight off the entire armada."]

[[:PiratesAttackStation :AllyCrew] [:AllyCrew :FoughtOffPirates :ShipDamaged :Reward]
"The hero and their loyal crew all agree the station must be protected. They fight valiantly but the ship is damaged in the process and must be towed into the station."]

;;AI takes over Station
[[:Ordeal :EnemyRogueAI :SpaceStation] [:AIStation]
"When the hero is being pulled into the station he realizes the station has been taken over by an Artifical Intelligence!"]

[[:AIStation :AllyExpert] [:ExpertSacrifice :StationDestroyed :Reward]
"The expert sacrifices themselves to rescue the hero and their ship, staying behind to make the station self destruct."]

[[:AIStation :AllyPirate] [:PiratesSaveStation :Reward]
"The hero's newfound pirate friends bring their whole fleet to fight the AI station."]

[[:AIStation :Starmaps][:AITakesShip :Reward]
"The hero gives up their ship and starmaps in return for the safety of the people on board the station."]

;;Hero caught by bounty hunter
[[:Ordeal :EnemyBountyHunter :SpaceStation] [:CaughtByBountyHunter]
"The bounty hunter has told the station authorities about the bounty, the ship is captured!"]

[[:CaughtByBountyHunter :OldFriend] [:OldFriendRescue :Reward]
"The hero is put in prison when it turns out the bounty hunter knows their old friend! They help the hero break out of prison and back to their ship"]

[[:CaughtByBountyHunter :AllyPirate] [:PirateRescue :Reward]
"The pirates the hero befriended set a plan to break the hero out of prison and have him join them."]

;;Ambushed by pirates in an asteroid belt
[[:Ordeal :EnemyPirate :AsteroidBelt] [:PirateBeltAmbush]
"Pirates laid a trap for the hero in the asteroid belt!"]

[[:PirateBeltAmbush :UpgradedShip] [:DefeatedPirates :Reward]
"With the upgraded ship the hero is able to defeat the pirates."]

[[:PirateBeltAmbush] [:HeroCapturedByPirates]
"The hero's ship is disabled and they are captured by the pirates!"] 

[[:HeroCapturedByPirates :AllyCrew] [:HeroEscapesPirates :Reward]
"The hero and their loyal crew execute a daring escape on one of their ships."]

[[:HeroCapturedByPirates :AllyExpert] [:HeroEscapesPirates :Reward]
"With the help of the Expert, The hero and their crew execute a daring escape on one of their ships."]

;;A swarm of rogue AI drones
[[:Ordeal :EnemyRogueAI :AsteroidBelt] [:RogueAISwarm]
"A swarm of Rogue AI drones are mining this asteroid belt."]

[[:RogueAISwarm :AllyExpert] [:SwarmDeactivated :Reward]
"The expert engineer creates a devices that deactivates the swarm at least temporarily."]

[[:RogueAISwarm] [:EscapeSwarm :Reward]
"The hero makes a daring escape after scouting the rogue swarm of machines, deftly flying between asteroids."]


;;Showdown with the bounty hunter
[[:Ordeal :EnemyBountyHunter :AsteroidBelt] [:BountyHunterShowdown] 
"The Bounty Hunter tracked the hero out here where they have a showdown."]

[[:BountyHunterShowdown :UpgradedShip] [:DefeatedBountyHunter :Reward]
"With the upgraded ship the hero is able to fight off the bounty hunter."]

[[:BountyHunterShowdown] [:HeroCapturedByBountyHunter :Reward]
"The Bounty Hunter disables the hero's ship and captures them."]

[[:HeroCapturedByBountyHunter :AllyCrew] [:BountyHunterShip :Reward]
"With the help of their loyal crew, the hero takes over the bounty hunter's ship and escapes!"]


;;we have a lot of ordeal blurbs that would be nice to recombine into a few paths.

;; a few main routes for this
;; 
;; Ship is Destroyed, new ship from Pirates or Bountyhunter
;; Ship is destroyed, stuck on space station.
;; Ship isn't destroyed, celebration on board ship.

;;Act 2 Reward
;;let's focus on the completion of the goal, cargo / signal / etc.

;;Celebration / Campfire / Woo we did it! (specific celebrations to story starts and then recombine stories.)
;; :StrangeReadings
;; :DistressCall
;; :TransportingCargo
;; :FerryingPassengers

;;Pirates attack station                        :StationRescued, :StationEvacuated
[[:Reward :FoughtOffPirates :FerryingPassengers] [:DeliverySuccess :PirateRevenge :RoadBack]
"The hero pulls through and manages to get the passengers safely delivered."]

[[:Reward :FoughtOffPirates :TransportingCargo] [:DeliverySuccess :PirateRevenge :RoadBack]
"The hero docks with the station and transfers the cargo they were meant to deliver."]


;;AI takes over Station                         :ExpertSacrifice :StationDestroyed, :LootedStation, :AITakesShip
[[:Reward :StationDestroyed :FerryingPassengers] [:StationEvacuated :PassengersOnShip :AIRevengeSwarm :RoadBack]
"With the expert's sacrifice, the hero rescues not only the passengers now without a destination, but also the station's crew."]

[[:Reward :StationDestroyed :TransportingCargo] [:StationEvacuated  :CargoOnShip :AIRevengeSwarm :RoadBack]
"With the expert's sacrifice and destruction of the station, the cargo is left on board the ship."]

[[:Reward :PiratesSaveStation :FerryingPassengers] [:DeliverySuccess :AIRevengePirate :RoadBack]
"Together with the pirates the hero manages to fight off the AI and deliver the passengers safely."]

[[:Reward :PiratesSaveStation :TransportingCargo] [:DeliverySuccess :AIRevengePirate :RoadBack]
"Together with the pirates the hero manages to fight off the AI and deliver their cargo safely,"]

[[:Reward :AITakesShip :FerryingPassengers] [:DeliverySuccessNoShip]
"The ship is unloaded of passengers before the AI takes it over, leaving the hero with no ship but a successful mission. "]

[[:Reward :AITakesShip :TransportingCargo] [:DeliverySuccessNoShip]
"The ship is unloaded of cargo before the AI takes it over, leaving the hero with no ship but a successful mission. "]

[[:DeliverySuccessNoShip] [:StayOnStation :RoadBack]
"The hero decides to stay on the space station for some time before looking for an opportunity to return home."]

;;Hero caught by bounty hunter                  :OldFriendRescue :PirateRescue

[[:Reward :OldFriendRescue :FerryingPassengers] [:DeliverySuccess :NewBountyHunter :RoadBack]
"During detainment the passengers are let onto the station by the authorities. "]

[[:Reward :OldFriendRescue :TransportingCargo] [:DeliverySuccess :NewBountyHunter :RoadBack] 
"Once released the hero is able to transfer the cargo to the space station."]

[[:Reward :PirateRescue :FerryingPassengers] [:DeliverySuccess :PirateBetrayal :RoadBack]
"During detainment the passengers are let onto the station by the authorities.  "]

[[:Reward :PirateRescue :TransportingCargo] [:DeliverySuccess :PirateBetrayal :RoadBack]
"The pirates take a few pieces of cargo as payment for their rescue but allow the hero to deliver the rest."]

;;Ambushed by pirates in an asteroid belt       :DefeatedPirates :HeroEscapesPirates
[[:Reward :DefeatedPirates :StrangeReadings] [:ValuableAsteroid :PirateRevenge :RoadBack]
"With the pirates defeated the hero investigates the strange readings which turned out to be an asteroid with exotic minerals."]

[[:Reward :DefeatedPirates :DistressCall] [:FakeDistressCall :PirateRevenge :RoadBack] 
"The pirates had set the distress call as a trap! "]

[[:Reward :HeroEscapesPirates :StrangeReadings] [:ValuableAsteroid :PirateRevenge :RoadBack]
"The hero loses the pirates in the asteroid belt, eventually circling back around to the strange readings and find an asteroid with exotic minerals"]

[[:Reward :HeroEscapesPirates :DistressCall] [:FakeDistressCall :PirateRevenge :RoadBack]
"The pirates had set the distress call as a trap! "]

;;A swarm of rogue AI drones                    :SwarmDeactivated :EscapeSwarm
[[:Reward :SwarmDeactivated :StrangeReadings] [:DroneReadings :AIRevengeSwarm :RoadBack]
"With the swarm deactivated the hero finds that the readings are coming from the drones themselves."]

[[:Reward :SwarmDeactivated :DistressCall ] [:DroneDisabledShip :AIRevengeSwarm :RoadBack]
"With the swarm deactivated the hero follows the distress call and finds a disabled ship floating through space that was attacked by the drones."]

[[:Reward :EscapeSwarm :StrangeReadings] [:DroneReadings :AIRevengeSwarm :RoadBack]
"Once the hero escapes the drones, they finds that the readings are coming from the drones themselves."]

[[:Reward :EscapeSwarm :DistressCall] [:DroneDisabledShip :AIRevengeSwarm :RoadBack]
"The hero manages to evade the drones and find their way to the source of the distress call, a disabled ship floating through space."]

;;Showdown with the bounty hunter               :DefeatedBountyHunter :BountyHunterShip]
[[:Reward :DefeatedBountyHunter :StrangeReadings] [:ValuableAsteroid :NewBountyHunter :RoadBack]
"After defeating the bounty hunter the hero investigates the strange readings which turned out to be an asteroid with exotic minerals."]

[[:Reward :DefeatedBountyHunter :DistressCall] [:FuelDistressCall :NewBountyHunter :RoadBack]
"After defeating the bounty hunter the hero rushes to the distress call, finding a ship that has run out of fuel!"]

[[:Reward :BountyHunterShip :StrangeReadings] [:ValuableAsteroid :NewBountyHunter :RoadBack]
"Taking over the bounty hunter's ship the hero investigates the strange readings which turned out to be an asteroid with exotic minerals. "]

[[:Reward :BountyHunterShip :DistressCall] [:FuelDistressCall :NewBountyHunter :RoadBack]
"Taking over the bounty hunter's ship the hero rushes to the distress call, finding a ship that has run out of fuel!"]

;;Act 2 can end with the following:


;; Pirate / Bounty Hunter Station resolutions       :DeliverySuccess , :StayOnStation
;; AI station resolutions                            :StationEvacuated (PassengersOnShip / CargoOnShip)
;; Pirate / Bounty hunter belt attack               :ValuableAsteroid , :FakeDistressCall , :FuelDistressCall 
;; Drone belt attack resolutions:                   :DroneReadings , :DroneDisabledShip

;; Act 3 The Road Back
;; Handling the mission success stuff. How do we bring an enemy back? it should be the same enemy to be coherent.

;;We should add the pursuing enemy here too
;; :PirateRevenge , :NewBountyHunter , :AIRevengePirate , :AIRevengeSwarm , :PirateBetrayal

;;DeliverySuccess paths
[[:RoadBack :DeliverySuccess] [:DeliverySuccess :HeroFlyingHome]
"After succeeding in their delivery mission, the hero begins their journey home."]

;;Evacuation comes with PassengersOnShip and CargoOnShip too, to be resolved in resurrection
[[:RoadBack :StationEvacuated] [:StationEvacuated :HeroFlyingHome]
"After evacuating the station personnel onto the ship, the hero begins their journey home."]

[[:RoadBack :FakeDistressCall ] [:HeroFlyingHome]
"Noting down the distress call as a fake the hero begins their journey home."]

[[:RoadBack :ValuableAsteroid ] [:CrystalCargo :HeroFlyingHome]
"The hero spends some time mining the asteroid for valuable crystals before starting their journey home."]

[[:RoadBack :FuelDistressCall ] [:EscortingShip :HeroFlyingHome]
"The hero docks with the stranded ship to transfer fuel to them, before starting to escort them back home."]

[[:RoadBack :DroneDisabledShip  ] [:EscortingShip :HeroFlyingHome]
"The hero docks with the disabled ship, finding the crew still alive. The hero's crew completes their repairs before starting to escort them back home."]

[[:RoadBack :DroneReadings] [:InfoOnAI :HeroFlyingHome ]
"Analyzing the readings from the drones provides some insights into their workings, the hero decides it best to take the information home."]
 
;;Handle the potential final conflicts for act 3
[[:HeroFlyingHome :PirateRevenge] [:PirateAmbush :Resurrection]
"Unaware of it, the pirates from earlier have regrouped and set an ambush for the hero!"]

[[:HeroFlyingHome :AIRevengePirate] [:AIPirateAttacks :Resurrection]
"Unaware of it, some of the allied pirates ships has been taken over by the AI!"]

[[:HeroFlyingHome :AIRevengeSwarm] [:SwarmPursuit :Resurrection]
"Fragments of the station come to life after the explosion, chasing the hero on their journey home!"]

[[:HeroFlyingHome :NewBountyHunter] [:BountyHunterPursuit :Resurrection]
"The bounty hunter managed to contact their friends, soon the hero finds more bounty hunters on their tail!"]

[[:HeroFlyingHome :PirateBetrayal] [:PirateBetrayal :Resurrection]
"The Pirates decide to take their chances to get the hero's bounty for themselves."]

;;Staying on station
[[:RoadBack :StayOnStation] [:StayOnStation :Resurrection]
"Staying on the station the hero spends some time helping the people on the station rebuild."]


;; Act 3 Resurrection
;;One last big conflict! Big climax of the story! 
;; This act starts with :PirateAmbush , :AIPirateAttacks , :SwarmPursuit , :BountyHunterPursuit , :PirateBetrayal , :StayOnStation
;; m

;;Pirate ambush finish, what variants?
[[:Resurrection :PirateAmbush] [:ReturnElixir]
"The pirate fleet regroups and ambushes the hero right before they get back home, who fights them off"]

[[:Resurrection :AIPirateAttacks] [:ReturnElixir]
"Some of the pirate's ships have been taken over by the AI and they attack the hero who manages to disable the AI control."]

[[:Resurrection :SwarmPursuit] [:ReturnElixir]
"The hero lures the pursuing swarm into an ambush and comes out victorious!"]

[[:Resurrection :BountyHunterPursuit] [:ReturnElixir]
"Eventually the bounty hunters catch up and force the hero into a pitched battle! The hero manages to win."]

[[:Resurrection :PirateBetrayal ] [:ReturnElixir]
"The pirates decide to betray the hero and cash in on the hero's bounty, forcing a battle which the hero manages to escape from."]

[[:Resurrection :StayOnStation] [:ReturnElixir]
"The hero spends their time repairing the station and organizing the survivors of the AI attack."]

;; Act 3 Return with the Elixir
[[:ReturnElixir] [:end]
"The hero returns home after their long adventure and a completed mission."]

[[:ReturnElixir :NotAbandonFamily] [:end]
"The hero returns home after their long adventure and a completed mission, happy to see their family again"]

[[:ReturnElixir :CrystalCargo] [:end]
"The hero returns home after their long adventure and sells the valuable crystal cargo to repair the ship."]

[[:ReturnElixir :EscortingShip] [:end]
"The hero returns home with the ship they have been escorting, who are grateful for the rescue."]

[[:ReturnElixir :InfoOnAI] [:end]
"The hero returns home with info on the artificial life form that must be studied. "]


])

