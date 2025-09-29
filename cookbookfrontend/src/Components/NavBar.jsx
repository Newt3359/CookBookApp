import React, { useState } from 'react';
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
} from 'reactstrap';
import {Link} from "react-router-dom"
import { FaUtensils } from "react-icons/fa6";


function Example(args) {
    const [isOpen, setIsOpen] = useState(false);

    const toggle = () => setIsOpen(!isOpen);

    return (
        <div>
            <Navbar {...args} light id="navbar">
                <NavbarBrand><FaUtensils className="me-2"/>CookBook</NavbarBrand>
                <NavbarToggler onClick={toggle} />
                <Collapse isOpen={isOpen} navbar>
                    <Nav className="me-auto" navbar>
                        <NavItem>
                            <Link to={"/"} className="nav-link">Home </Link>
                        </NavItem>
                        <NavItem>
                            <Link className="nav-link" to="/addRecipe">Add Recipe</Link>
                        </NavItem>
                        <NavItem>
                            <Link className="nav-link" to="/searchRecipe">Read Recipe</Link>
                        </NavItem>
                        <NavItem>
                            <NavLink className="NavText">Create Shopping List</NavLink>
                        </NavItem>
                    </Nav>
                </Collapse>
            </Navbar>
        </div>
    );
}

export default Example;