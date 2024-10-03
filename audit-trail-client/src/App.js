import React, { useState, useEffect } from 'react';
import PlatformSelector from './components/PlatformSelector/PlatformSelector';
import LogList from './components/LogList/LogList';
import platformService from './services/platformService';
import './App.css'; // Main CSS file for layout

const App = () => {
  const [selectedSystem, setSelectedSystem] = useState(null);
  const [platforms, setPlatforms] = useState([]);

  useEffect(() => {
    fetchPlatforms();
  }, []);

  const fetchPlatforms = async () => {
    try {
      const response = await platformService.getPlatforms();
      setPlatforms(response.data);
    } catch (error) {
      console.error('Error fetching platforms:', error);
    }
  };

  const handleSystemChange = (system) => {
    setSelectedSystem(system);
  };
  const handleUpdatePlatform = (updatedPlatform) => {
    setPlatforms((prevPlatforms) =>
      prevPlatforms.map((platform) =>
        platform.systemName === updatedPlatform.systemName ? updatedPlatform : platform
      )
    );
  };

  return (
    <div className="app-container">
      <div className="system-selector-container">
        <PlatformSelector
          platforms={platforms} 
          selectedSystem={selectedSystem} 
          onSystemChange={handleSystemChange} 
          onUpdatePlatform={handleUpdatePlatform}
        />
      </div>

      <div className="log-list-container">
        {selectedSystem ? (
          <LogList selectedSystem={selectedSystem} />
        ) : (
          <div className="no-system-selected">
            <h3>Please select a system to view its logs.</h3>
          </div>
        )}
      </div>
    </div>
  );
};

export default App;
