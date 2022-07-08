let baseUrl = "http://localhost:8082"

async function submitRequest()
{
    console.log("request submission button pressed")

    
        //gather input from the employee - using our DOM
        let empId = document.getElementById('employeeIdInput').value;
        
        let currentDateInput = document.getElementById('currentDateInput').value;
        
        let compProofDropdown = document.getElementById('compProofDropdown').value;
       
        let eventDateInput = document.getElementById('eventDateInput').value;
       
        let eventTimeInput = document.getElementById('eventTimeInput').value;
       
        let eventLocationInput = document.getElementById('eventLocationInput').value;
       
        let eventDescInput = document.getElementById('eventDescInput').value;
       
        let eventCostInput = document.getElementById('eventCostInput').value; 
       
        let eventTypeDropdown = document.getElementById('eventTypeDropdown').value;
       
        let workJustInput = document.getElementById('workJustInput').value;
       
        let projReimInput = document.getElementById('projReimInput').value;
       
        let gradeReqInput = document.getElementById('gradeReqInput').value;
       
        let gradeFormatInput = document.getElementById('gradeFormatInput').value;
    
        //create an object literal
        let request = {
            empId: empId,
            requestDate: currentDateInput,
            compProof: compProofDropdown,
            eventDate: eventDateInput,
            eventTime: eventTimeInput,
            eventLocation: eventLocationInput,
            eventDesc: eventDescInput,
            eventCost: eventCostInput,
            eventType:eventTypeDropdown,
            workJust: workJustInput,
            projReim: projReimInput,
            gradeReq: gradeReqInput,
            gradeFormat: gradeFormatInput
        }
    
        //print to console
        console.log(request);

    //converting request object literal to a Json string so it can be sent in the body of the request
    let requestJson = JSON.stringify(request);
    console.log(requestJson);

    //sending POST request to our backend using the Fetch API
    let res = await fetch(
        `${baseUrl}/employee/${empId}/newrequest`,  //URL we are sending this request to
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: requestJson
        }
    );
    let resJson = await res.json()
        //.then executes if promise is successfully resolved, otherwise if there is an error .catch will execute.
        //.catch takes a function as an argument
        .then((resp) => {
            console.log(resp); //we will add DOM manipulation here eventually if needed
            window.location.assign("employeehomepage.html")
        })
        .catch((error) => {
            console.log(error);
        });
}

    