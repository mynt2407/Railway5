import axios from 'axios';

const axiosClient = axios.create({
    baseURL: `https://5f47b29395646700168d9bd1.mockapi.io/api/v1`,
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