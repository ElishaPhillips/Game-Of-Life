You can open the whole folder in Intellij Idea and everything *should* work properly. It does run and prints the first generation (: 

The main class is 'Life' under:
	 src -> Life -> Life

What I got so far: 

The three additional classes in the package: 

lifeBoard - manages the arrays 

  generateEmptyBoard
	- inputs size and makes an array  filled with dead '.' 	values 

  generateStartingBoard
	- inputs size and makes an array  filled with an array 	that includes the starting live cells 

  isDead
	-inputs the array and the location (x,y) of the value to 	change to dead '.' 

  isLive
	-inputs the array and the location (x,y) of the value to 	change to live 'O' 

nextGen - engine that calculates the generation changes and prints all the stuff out 

  initiateGame 
      -starting sequence that prints the beginning headers and 	the first generation grid

	- fills the initial currentGrid and nextGrid, and sets the 	gencounter to zero

  test
	-just a tester class that'll print out the current two 	arrays for the gameboard, figured it be helpful when 	trying to write the generation calculator 
	
print - overrides the 'toString' and formats the string lines to print out 

   toString 
	- inputs an array, returns as a printable formatted string 
      