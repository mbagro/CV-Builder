/**
 * 
 * Disable Any key press on Form Text Input.
 */

function keyDisable(event)
{

window.addEventListener('keydown', function (event) {

if (event.keyCode == 32) //ASCII of Space is 32
	event.preventDefault(); //Prevents other events to occur.
	
});

}
