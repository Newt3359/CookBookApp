import React, {useState,useEffect} from "react";

function SearchBar() {
    const [searchQuery, setSearchQuery] = useState('');
    const [searchResults, setSearchResults] = useState([]);

    const handleInputChange = (event) =>{
        setSearchQuery(event.target.value);
    };

    const handleSearch = async () => {
        try{
            const response = await fetch(`/api/recipe/search?query=${searchQuery}`);
            const data = await response.json();
            setSearchResults(data);
        }catch (error){
            console.error('Error fetching search results', error);
        }
    };

    return(
        <div>
            <input
            type="text"
            placeholder="Search"
            value={searchQuery}
            onChange={handleInputChange}
            />
            <button onClick={handleSearch}>Search</button>
            <div>
                {searchResults.length>0 ?(
                    <ul>
                        {searchResults.map((item) =>(
                            <li>key={item.id}>{item.name}</li>
                        ))}
                    </ul>
                ) : (
                    <p>No results found.</p>
                )}
            </div>
        </div>
    );
}

export default SearchBar;