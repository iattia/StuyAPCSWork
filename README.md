[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/FHJZpE55)
# APCS - Stuyrim


## Features


Make a clear list of features that work/dont work


:white_check_mark: This feature works.


:question: This feature works partially.


:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.


:x: This required feature does not work.


:beetle: This is a bug that affects the game.




## Adventurer Subclasses


## Overview


A turn-based combat game where players control Adventurers with unique resources, attacks, and support abilities while facing powerful bosses.






## Special Features


### Advanced Combat Mechanics (Not for all Adventurers)
- Status effects
- Critical hit chance
- Defense and damage mitigation


### Evolution System
- Each Adventurer can **evolve once per game**.
- Evolution:
  - Consumes the Adventurer’s turn.
  - Consumes 25% of max Special Resource
  - Restores **10% of current health** (cannot exceed max health).
  - Grants a **team-wide shield**, reducing incoming damage by **25% for that turn only**.






## Adventurers


### Giant
- **Special Resource:** Cows
- **Attack:** Punch
- **Special Attack:**
  - Throws cows to deal **area damage**.
- **Support:**
  - Heals a target for **5% of their max health**.




### Witch
- **Special Resource:** Mana
- **Attack:** Spell
- **Special Attack:**
  - Casts a denser spell that deals **increased damage**.
- **Support:**
  - Heals a target for **10% of their max health**.




### Healer
- **Special Resource:** Vitality
- **Attack:** Hit
- **Special Attack:**
  - Deflects **10% of incoming damage** back to the original enemy.
- **Support:**
  - Heals the **entire team** for **15% of their max health**.




## Bosses


### John Pork
- **Special Resource:** 5G Waves
- **Attack:** Call
- **Special Attack:**
  - Emits 5G waves that irradiate enemies.
- All enemies lose **10% of their health per turn for 2 turns**.
- **Support:**
  - Heals self for **30% of max health**.





## Notes


- All percentages are subject to balancing.
