import axios from 'axios';

const API_URL = 'http://localhost:8080/Platform';

const getPlatforms = () => {
    return axios.get(API_URL);
};

const addPlatform = (platform) => {
    return axios.post(API_URL, platform);
};
const updatePlatformByName = (systemName, platform) => {
    return axios.put(`${API_URL}/${systemName}`, platform);
};


const deletePlatform = (systemName) => {
    return axios.delete(`${API_URL}/${systemName}`);
};

export default {
    getPlatforms,
    addPlatform,
    deletePlatform,
    updatePlatformByName
};
