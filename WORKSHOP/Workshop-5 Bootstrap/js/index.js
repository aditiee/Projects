function add()
{
    let text=document.querySelector("textarea").value;
    // console.log(text);
    // document.querySelector("#para").innerHTML=text;
 

    let span = document.querySelector("#span");
    let comment =   document.querySelector("#para").cloneNode();
    comment.innerHTML=text;
    span.appendChild(comment);
    document.querySelector("textarea").value=" ";

}
