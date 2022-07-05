function getAllRequests(){
}

let requestDiv = document.getElementById("requests");

let nameHeader = document.createElement('h3');
nameHeader.innterHTML = requests.name;

requestsDiv.append(nameHeader);

// requestsJSON = JSON.stringify(requests);

// requestsDiv.innerHTML = requestsJSON;