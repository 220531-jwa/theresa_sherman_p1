
let baseUrl = "http://localhost:8082";

async function login()
{
    console.log("login button pressed")

    //gather input from the employee - using our DOM
    let usernameInput = document.getElementById('usernameInput').value;

    let passwordInput = document.getElementById('passwordInput').value;

    //create an object literal
    let employee = 
    {
        username: usernameInput,
        password: passwordInput
    }

    //print to the console
    console.log(employee);

//converting employee object literal to a Json string so it can be sent in the body of the request
let employeeJson = JSON.stringify(employee);
console.log(employeeJson);

//sending POST request to our backend using the Fetch API
    let res = await fetch(
            `${baseUrl}/login`,  //URL we are sending this request to
    {
        method: 'POST',
        header: {'Content-Type': 'application/json'},
        body: employeeJson
    }
    );
let resJson = await res.json()
//.then executes if promise is successfully resolved, otherwise if there is an error .catch will execute.
//.catch takes a function as an argument
.then((resp) => 
{
    console.log(resp); //we will add DOM manipulation here eventually if needed
    window.location.assign("employeehomepage.html")
})
.catch((error) =>
{
    console.log(error);
});
}


