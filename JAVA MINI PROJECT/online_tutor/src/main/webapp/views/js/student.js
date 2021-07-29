var logout = function() {
    sessionStorage.removeItem('email');
    window.location.replace('./login.html');

}

var subscription=function(){
	windows.location.replace('./subscriptiontable.html')
}