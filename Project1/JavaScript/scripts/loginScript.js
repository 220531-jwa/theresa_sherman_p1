let loginButton = document.getElementById('loginButton');

//commented out b/c it the method is placed in loginpage.html instead
//creating event listener for login button
// loginButton.addEventListener('submit', Loginattempted);
// function Loginattempted(){
//     console.log('Login attempted');
//}

let baseUrl = "http://localhost:8081/login/";

async function getEmpUsername()
{
    let usernameInput = document.getElementById('usernameInput').value;
    console.log(usernameInput);
    let res = await fetch(`${baseUrl}/${usernameInput}`);

    if(res.status == 200)
    {
        let data = await res.json();
        console.log(data);
    } 
        else
        {
            console.log("That username does not exist");
        }
}
    


async function getEmpPassword()
{
    let passwordInput = document.getElementById('passwordInput').value;
    console.log(passwordInput);
    await fetch(`${baseUrl}/${passwordInput}`);

    console.log(Response);
}

async function getEmpRole()
{
    let roleInput = document.getElementById('roleInput').value;
    console.log(roleInput);
    await fetch(`${baseUrl}/${empRoleInput}`);

    console.log(Response);
}

//tell browser to login the employee or that credentials do not exist, try again.