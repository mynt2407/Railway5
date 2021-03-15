import axiosClient1 from "./axiosCreate";

const url = "/todos";

const getAll = () => {
    return axiosClient1.get(url);
}
const getById = (id) => {
    return axiosClient1.get(`${url}/${id}`);
}
const create = (body) => {
    return axiosClient1.post(url, body);
}
const updateById = (id, body) => {
    return axiosClient1.put(`${url}/${id}`, body);
}
const deleteById = (id) => {
    return axiosClient1.delete(`${url}/${id}`);
}
const EmployessApi = { getAll, getById, create, updateById, deleteById }
export default EmployessApi;