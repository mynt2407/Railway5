import React from 'react';
import Login from './Login';
import LoginContext from './LoginContext';

function withAuth(LoginComponent) {
    class HOC extends React.Component {
        isLogin = () => {
            return this.context;
        }
        render() {
            return !this.isLogin() ? <Login /> : <LoginComponent {...this.props} />
        }
    }
    HOC.contextType = LoginContext;
    return HOC;
}
export default withAuth;