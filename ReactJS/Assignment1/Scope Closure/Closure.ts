function getGreeting(firstName: string, lastName: string) {
    function greeting() {
        return firstName + " " + lastName;
    }
    return greeting();

}
var x = getGreeting("My Nguyen", "Thi");
console.log(x);