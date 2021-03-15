import React from 'react';
import EmployessApi2 from './UserApi';
import UserList from './UserList';
import WithLoading from './withLoading';

class UserContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    getListEmployee = function () {

        // Phuong thuc da duoc viet san trong FunctionApi

        EmployessApi2.getAll()
            .then(data => {
                this.setState(
                    {
                        users: data
                    });
            })
            .catch(error => console.log("Loi roi"));
    }

    componentDidMount() {
        this.getListEmployee();
    }

    render() {
        const UserHasLoading = WithLoading(UserList);
        return (
            <UserHasLoading
                isLoading={this.state.users.length === 0}
                users={this.state.users}
            />
        )
    }

}
export default UserContainer;