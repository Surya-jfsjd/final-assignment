const buttoncalled=document.getElementById("button");
buttoncalled.addEventListener('click', submit)
const getButtoncalled=document.getElementById("get");
getButtoncalled.addEventListener('click', get)

function submit(){
    let name1=document.getElementById("firstName").value;
    let name2=document.getElementById("middleName").value;
    let name3=document.getElementById("lastName").value;
    let request = new Request('http://localhost:8080/registrations',{
        headers: new Headers({
            
            'Content-type': 'application/json'
        }),
        method: 'POST',
        body: JSON.stringify({
            "firstName": name1,
            "middleName": name2,
            "lastName": name3
        })
});
fetch(request).then((response)=>{
    console.log(response);
    response.json().then((data)=>{
        console.log(data);
    })
})
}