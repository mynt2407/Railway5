import axiosClient from "./axiosCreate";

const url = "/users";

const existByEmail = (email) => {
    return axiosClient.get(`${url}/email/${email}`);
}

const existUserName = (username) => {
    return axiosClient.get(`${url}/userName/${username}`);
}

const reSendEmail = (email) => {
    const parameters = {
        email: email
    }

    return axiosClient.get(`${url}/userRegistrationConfirmRequest`, { params: parameters })
}

const create = (userName, email, firstName, lastName, password) => {
    const body = {
        userName: userName,
        email: email,
        firstName: firstName,
        lastName: lastName,
        password: password
    }

    return axiosClient.post(url, body);
}

const UserApi = { create, existByEmail, existUserName, reSendEmail }
export default UserApi;