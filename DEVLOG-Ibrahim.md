# Dev Log:

## Ibrahim Attia

### 2026-05-08 - Worked on PROTOTYPE
After renaming all the files and adding our names, I started working on Section 1 of Prototype. All in all, it took around 45 minutes to write out all the critical and nice-to-have features. Everything else like the brief project description and group name didn't really take much time.

### 2026-05-11 - Worked on diagrams
Began working on diagrams for each screen using Google Slides

### 2026-05-12 - Finished diagrams
Finished making the diagrams, mostly just working out the kinks with dimensions, colors, and formats

### 2026-05-13 - Skeleton code for tiles
Started working on Tile code, mostly just set up the structure.

### 2026-05-14 - Finished Board class and visual layout
Completed Board.pde. I filled out the array with all 40 tiles with names, prices, rents, and color groups for the properties. I also wrote the draw() method to render the board on the screen.

### 2026-05-15 - Worked on file structure
Removed unnecessary extra file and started working on a new chance tile class because they work differently from all the other tiles. Still a WIP.

### 2026-05-18 - Worked on game functionality
Mostly prevented game from crashing. Fixed payment and purchasing logic, especially when trying to buy non-properties or when trying to buy things like utilities or railroads which work a bit differently.

### 2026-05-19 - Added text popups and better property management
Replaced print statements with an actual text pop up in the center of the screen. Added a color coordination system to make it clearer which token owns each property. Added some chance/community tile possibilities.