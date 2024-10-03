import axios from 'axios';

const API_URL = 'http://localhost:8080/Logs';

const getLogs = () => {
    return axios.get(API_URL);
};

const addLog = (log) => {
    return axios.post(API_URL, log);
};

const deleteLogs = () => {
    return axios.delete(API_URL);
};

const deleteLogById = (logId) => {
    return axios.delete(`${API_URL}/${logId}`);
};

export default {
    getLogs,
    addLog,
    deleteLogs,
    deleteLogById,
};
