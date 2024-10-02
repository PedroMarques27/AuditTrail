import React from 'react';
import './LogFilter.css';

const LogFilter = ({ filter, setFilter, fetchLogs }) => {
  const handleStartTimestampChange = (e) => {
    const timestamp = new Date(e.target.value).getTime();
    setFilter({ ...filter, startTimestamp: timestamp });
  };

  const handleEndTimestampChange = (e) => {
    const timestamp = new Date(e.target.value).getTime();
    setFilter({ ...filter, endTimestamp: timestamp });
  };
  const Level = {
    INITIALIZATION: 'INITIALIZATION',
    TERMINATION: 'TERMINATION',
    DEBUG: 'DEBUG',
    INFORMATION: 'INFORMATION',
    WARNING: 'WARNING',
    ERROR: 'ERROR',
    FATAL: 'FATAL',
  };
  
  const HttpCode = {
    GET: 'GET',
    POST: 'POST',
    PUT: 'PUT',
    DELETE: 'DELETE',
  };
  return (
    <div className="log-filter">
    
        <select 
            value={filter.level} 
            onChange={(e) => setFilter({ ...filter, level: e.target.value })}
          >
            <option value="">Filter by Level</option>
            {Object.values(Level).map(level => (
              <option key={level} value={level}>{level}</option>
            ))}
          </select>
          <select 
            value={filter.httpCode} 
            onChange={(e) => setFilter({ ...filter, httpCode: e.target.value })}
          >
            <option value="">Filter by HTTP Code</option>
            {Object.values(HttpCode).map(code => (
              <option key={code} value={code}>{code}</option>
            ))}
        </select>
      <input
        type="datetime-local"
        onChange={handleStartTimestampChange}
      />
      <input
        type="datetime-local"
        onChange={handleEndTimestampChange}
      />
      <button onClick={fetchLogs}>Filter</button>
    </div>
  );
};

export default LogFilter;
