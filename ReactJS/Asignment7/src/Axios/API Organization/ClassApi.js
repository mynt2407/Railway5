import axiosClient from "./axiosCreate";

class EmployeeApi2 {
    constructor() {
        this.url = "/api/v1/employees"
    }
    getAll = () => {
        return axiosClient.get(this.url);
    };
    getById = (id) => {
        return axiosClient.get(`${this.url}/${id}`);
    }
    create = (body) => {
        return axiosClient.post(this.url, body);
    }
    updateById = (id, body) => {
        return axiosClient.put(`${this.url}/${id}`, body);
    }
    deleteById = (id) => {
        return axiosClient.delete(`${this.url}/${id}`);
    }
}
const employeeAp2 = new EmployeeApi2();
export default employeeAp2;