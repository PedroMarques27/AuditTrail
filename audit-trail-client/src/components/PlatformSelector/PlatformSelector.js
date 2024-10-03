import React, { useState } from 'react';
import platformService from '../../services/platformService'; // Import platformService for updating data
import './PlatformSelector.css';

const PlatformSelector = ({ platforms, selectedSystem, onSystemChange, onUpdatePlatform }) => {
  const [isEditing, setIsEditing] = useState(false);
  const [editedPlatform, setEditedPlatform] = useState({
    host: '',
    healthEndpoint: ''
  });

  // Toggle edit mode and initialize editedPlatform with current platform data
  const toggleEdit = (platform) => {
    setIsEditing(!isEditing);
    setEditedPlatform({ host: platform.host, healthEndpoint: platform.healthEndpoint });
  };

  // Handle changes in the input fields
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditedPlatform({ ...editedPlatform, [name]: value });
  };

  // Save changes and update platform
  const saveChanges = async (platform) => {
    try {
      const updatedData = {
        ...platform,
        host: editedPlatform.host,
        healthEndpoint: editedPlatform.healthEndpoint
      };
      await platformService.updatePlatformByName(selectedSystem, updatedData);
      onUpdatePlatform(updatedData);
      setIsEditing(false); // Exit edit mode after saving
    } catch (error) {
      console.error('Error updating platform:', error);
    }
  };

  return (
    <div className="system-selector">
      <h3>Select System</h3>
      <select value={selectedSystem} onChange={(e) => onSystemChange(e.target.value)}>
        <option value="">Select a system</option>
        {platforms.map(platform => (
          <option key={platform.systemName} value={platform.systemName}>{platform.systemName}</option>
        ))}
      </select>

      {selectedSystem && platforms.filter(p => p.systemName === selectedSystem).map(platform => (
        <div key={platform.systemName} className="system-selector-details">
          <h4>Platform Details</h4>
          {isEditing ? (
            <div>
              <label>
                Host:
                <input
                  type="text"
                  name="host"
                  value={editedPlatform.host}
                  onChange={handleInputChange}
                />
              </label>
              <label>
                Health Endpoint:
                <input
                  type="text"
                  name="healthEndpoint"
                  value={editedPlatform.healthEndpoint}
                  onChange={handleInputChange}
                />
              </label>
              <button onClick={() => saveChanges(platform)}>Save</button>
              <button onClick={() => setIsEditing(false)}>Cancel</button>
            </div>
          ) : (
            <div>
              <p><strong>Host:</strong> {platform.host}</p>
              <p><strong>Health Endpoint:</strong> {platform.healthEndpoint}</p>
              <button onClick={() => toggleEdit(platform)}>Edit</button>
            </div>
          )}
        </div>
      ))}
    </div>
  );
};

export default PlatformSelector;
