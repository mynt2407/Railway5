import axios from 'axios';

const axiosClient = axios.create({
    baseURL: `https://5fa3f6a7f10026001618e3ae.mockapi.io/`
   // timeout: 1000
});

axiosClient.interceptors.request.use(async (config) => {
    // Add token here
    return config;
});
axiosClient.interceptors.response.use((response) => {
    if (response && response.data) {
        //get data
        return response.data;
    }
    return response;
}, (error) => {
    throw error;
});

export default axiosClient;