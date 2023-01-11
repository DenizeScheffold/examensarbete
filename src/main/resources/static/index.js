//TODO make all child element to change color.
function buttonColor() {
    let elementML = document.getElementById("button-change-color-monday-L");
    if (elementML.style.backgroundColor === "green") {
        elementML.style.backgroundColor = "red";
    } else {
        elementML.style.backgroundColor = "green";
    }
    return elementML;
}

function buttonColorMH() {
    let elementMH = document.getElementById("button-change-color-monday-H");
    if (elementMH.style.backgroundColor === "green") {
        elementMH.style.backgroundColor = "red";
    } else {
        elementMH.style.backgroundColor = "green";
    }
    return elementMH;
}

//TODO save input to JSON file
function onSubmit(elementML, elementMH) {
    const elements = {elementML, elementMH};
    JSON.stringify(elements);
    console.log(elements);
    /*
    let planToSubmit = document.getElementsByClassName('grid-child-element')[0];
    if (document.getElementById("button-change-color").style.backgroundColor === "green"){
        const mondayLGreen = planToSubmit;
        console.log("L possible", mondayLGreen);
    }
    else{
        const mondayLRed = planToSubmit;
        console.log(mondayLRed);
    }
*/
}







