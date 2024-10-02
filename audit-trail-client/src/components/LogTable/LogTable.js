import React, { useState } from 'react';
import ReactPaginate from 'react-paginate';
import './LogTable.css';
import logService from '../../services/logService';

const LogTable = ({ logs, filter, fetchLogs }) => {
  // State for pagination
  const [currentPage, setCurrentPage] = useState(0);
  const itemsPerPage = 10;

  // Filter logs based on filter criteria
  const filteredLogs = logs.filter(log => 
    (filter.level ? log.level === filter.level : true) &&
    (filter.httpCode ? log.requestInformation?.method === filter.httpCode : true) &&
    log.timestamp >= filter.startTimestamp &&
    log.timestamp <= filter.endTimestamp
  );

  // Logs to be displayed on the current page
  const paginatedLogs = filteredLogs.slice(
    currentPage * itemsPerPage, 
    (currentPage + 1) * itemsPerPage
  );

  // Handle pagination changes
  const handlePageChange = (selectedPage) => {
    setCurrentPage(selectedPage.selected);
  };

  // Handle log deletion
  const deleteLog = async (logId) => {
    try {
      await logService.deleteLog(logId);
      fetchLogs(); // Refresh the logs after deletion
    } catch (error) {
      console.error('Error deleting log:', error);
    }
  };

  return (
    <div className="log-table">
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>System Name</th>
            <th>Level</th>
            <th>Message</th>
            <th>Timestamp</th>
            <th>Request Method</th>
            <th>Request URL</th>
            <th>Response Status Code</th>
            <th>Response Body</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {paginatedLogs.length > 0 ? (
            paginatedLogs.map(log => (
              <tr key={log.id}>
                <td>{log.id}</td>
                <td>{log.systemName}</td>
                <td>{log.level}</td>
                <td>{log.message}</td>
                <td>{new Date(log.timestamp).toLocaleString()}</td>
                <td>{log.requestInformation?.method || 'N/A'}</td>
                <td>{log.requestInformation?.url || 'N/A'}</td>
                <td>{log.responseInformation?.statusCode || 'N/A'}</td>
                <td>{log.responseInformation?.responseBody || 'N/A'}</td>
                <td>
                  <button onClick={() => deleteLog(log.id)}>Delete</button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="10">No logs available</td>
            </tr>
          )}
        </tbody>
      </table>

      {/* Pagination component */}
      <ReactPaginate
        nextLabel="next >"
        onPageChange={handlePageChange}
        pageRangeDisplayed={3}
        marginPagesDisplayed={2}
        pageCount={Math.ceil(filteredLogs.length / itemsPerPage)}
        previousLabel="< previous"
        containerClassName="pagination"
        pageClassName="pagination-item"
        pageLinkClassName="pagination-link"
        previousClassName="pagination-item"
        nextClassName="pagination-item"
        activeClassName="active"
      />
    </div>
  );
};

export default LogTable;
