import Api from './Api';

const url = "/employees";

const getAll = () => {
    return Api.get(url);
};

const getByID = (id) => {
    return Api.get(`${url}/${id}`);
};

const existsByEmail = (email) => {
    return Api.get(`${url}/${email}`);
};

const create = (body) => {
    return Api.post(url, body);
};

const updateByID = (id, body) => {
    return Api.put(`${url}/${id}`, body);
}

const deleteByID = (id) => {
    return Api.delete(`${url}/${id}`);
}

// export
const EmployeeApi = { getAll, getByID, existsByEmail, create, updateByID, deleteByID }
export default EmployeeApi;

