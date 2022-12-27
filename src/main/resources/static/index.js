//TODO make all child element to change color.
function buttonColor() {
    let element =  document.getElementById("button-change-color");
    if (element.style.backgroundColor == "green") {
       element.style.backgroundColor = "red";
    } else {
        element.style.backgroundColor = "green";
    }

}

//TODO save input to JSON file
function onSubmit() {

    let planToSubmit = document.getElementsByClassName('grid-child-element')[0];
    if (document.getElementById("button-change-color").style.backgroundColor == "green"){
        const mondayLGreen = planToSubmit;
        console.log("L possible", mondayLGreen);
    }
    else{
        const mondayLRed = planToSubmit;
        console.log(mondayLRed);

    }


}




