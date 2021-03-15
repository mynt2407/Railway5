import axios from 'axios';

const axiosClient = axios.create({
    baseURL: `https://5f47b29395646700168d9bd1.mockapi.io`,
    timeout: 50000
})
export default axiosClient;