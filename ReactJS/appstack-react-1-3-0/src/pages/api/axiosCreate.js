import axios from 'axios';

const axiosClient = axios.create({
    baseURL: `http://localhost:8080/api/v1`,
   // timeout: 1000
   //responseType: 'json'
});

axiosClient.interceptors.request.use(async (config) => {
    // Add token here
    return config;
});
//if respone = true va co data thi tra ra response.data. Do vay neu respone = false => chi tra ra respone thoi
axiosClient.interceptors.response.use((response) => {
    if (response && response.data !== undefined) {
        //get data
        return response.data;
    }
    return response;
}, (error) => {
    throw error;
});

export default axiosClient;