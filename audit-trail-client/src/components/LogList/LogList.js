import React, { useEffect, useState } from 'react';
import logService from '../../services/logService';
import platformService from '../../services/platformService';
import LogFilter from '../LogFilter/LogFilter';
import LogTable from '../LogTable/LogTable';
import PlatformSelector from '../PlatformSelector/PlatformSelector';
import './LogList.css';

const LogList = ({ selectedSystem }) => {
  const [logs, setLogs] = useState([]);
  const [platforms, setPlatforms] = useState([]);
  const [filter, setFilter] = useState({
    id: '',
    level: '',
    httpCode: '',
    startTimestamp: Date.parse("1970-01-01T00:00:00Z"),
    endTimestamp: Date.now(),
  });

  useEffect(() => {
    fetchPlatforms();
  }, []);

  useEffect(() => {
    if (selectedSystem) {
      fetchLogs();
    }
  }, [selectedSystem]);

  const fetchPlatforms = async () => {
    try {
      const response = await platformService.getPlatforms();
      setPlatforms(response.data);
    } catch (error) {
      console.error('Error fetching platforms:', error);
    }
  };

  const fetchLogs = async () => {
    try {
      const response = await logService.getLogs();
      const filteredLogs = response.data.filter(log => log.systemName === selectedSystem);

      setLogs(filteredLogs);
    } catch (error) {
      console.error('Error fetching logs:', error);
    }
  };


  return (
    <div className="log-list">
  
     

      <LogFilter 
        filter={filter} 
        setFilter={setFilter} 
        logs={logs} 
        fetchLogs={fetchLogs} 
      />
      <LogTable logs={logs} filter={filter} />
    </div>
  );
};

export default LogList;
