import SplashPage from "./Pages/SplashPage.jsx";
import AddRecipe from "./Pages/AddRecipe.jsx";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavBar from "./Components/NavBar.jsx";
import SearchRecipe from "./Pages/SearchRecipe.jsx";

function App() {

  return (
        <Router>
            <NavBar />
            <Routes>
                <Route path="/" element={<SplashPage />} />
                <Route path="/addRecipe" element={<AddRecipe />} />
                <Route path="/searchRecipe" element={<SearchRecipe />} />
                {/*<Route path="/contact" element={<ContactPage />} />*/}
            </Routes>
        </Router>
    );
}
export default App
