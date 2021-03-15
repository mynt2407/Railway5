import React from "react";

class LoginController extends React.Component {
    constructor(props) {
        super(props);
        this.state = { isLoggedIn: false };
    }
    handleLogoutClick = () => {
        this.setState({ isLoggedIn: false });
    }
    handleLoginClick = () => {
        this.setState({ isLoggedIn: true });
    }

    render() {
        const isLoggedIn = this.state.isLoggedIn;
        let button;

        if (isLoggedIn) {
            button = <LogoutButton onClick={this.handleLogoutClick} />;
        } else {
            button = <LoginButton onClick={this.handleLoginClick} />;
        }
        return (
            <div>
                <Greeting isLoggedIn={isLoggedIn} />
                {button}
            </div>
        );
    }
}
function Greeting(props) {
    const isLoggedIn = props.isLoggedIn;
    if (isLoggedIn) {
        return <UserGreeting />;
    } else {
        return <GuestGreeting />;
    }

}

function UserGreeting(props) {
    return <h1>Welcom cưng!</h1>;
}
function GuestGreeting(props) {
    return <h1>Login đi đã cưng!</h1>;
}

function LoginButton(props) {
    return (
        <button onClick={props.onClick}>
            Login
        </button>
    );
}
function LogoutButton(props) {
    return (
        <button onClick={props.onClick}>
            Logout
        </button>
    );
}

export default LoginController;