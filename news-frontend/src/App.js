import React, { useEffect, useState } from 'react';

function App() {
  const [news, setNews] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Call the backend API endpoint
    fetch('/api/news')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Failed to fetch news');
        }
        return response.json();
      })
      .then((data) => {
        // Assuming the response has a structure like: { data: [ ... ] }
        setNews(data.data);
      })
      .catch((error) => {
        console.error('Error fetching news:', error);
        setError(error.message);
      });
  }, []);

  return (
    <div className="App">
      <h1>Latest News</h1>
      {error && <p>Error: {error}</p>}
      {news ? (
        <ul>
          {news.map((item, index) => (
            <li key={index}>
              <h2>{item.title}</h2>
              {item.image && <img src={item.image} alt={item.title} style={{maxWidth: "300px"}} />}
              <p>{item.description}</p>
              <a href={item.url} target="_blank" rel="noopener noreferrer">Read more</a>
            </li>
          ))}
        </ul>
      ) : (
        <p>Loading news...</p>
      )}
    </div>
  );
}

export default App;
