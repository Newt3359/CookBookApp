import {
    Form,
    Input,
    Label
} from "reactstrap";
import React, {useState} from "react";


function NewRecipe() {

    const [Title, setTitle] = useState('');
    const [Desc, setDesc] = useState('');
    const [Ingred, setIngred] = useState('')
    const [Favorite, setFavorite] = useState(true)

    const handleOptionChange = (event) => {
        setFavorite(event.target.value === 'true');
    };

    const handleSubmit = async (event) =>{
        event.preventDefault();

        const formData = {
            title: Title,
            description: Desc,
            ingredients: Ingred,
            favorite: Favorite
        };

        try {
            const response = await fetch('http://localhost:8080/api/recipe', {
                method: "POST",
                headers:{
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData),
            });

            if (response.ok){
                console.log('Form submit Success')
                setTitle('');
                setDesc('');
                setIngred('');
                setFavorite(true)
            }else {
                console.error("Form submit failure");
            }
        }catch (error){
            console.error("Error during form submission", error);
        }
    };

    return(

<div className="container-fluid">
    <Form id="Add Form" onSubmit={handleSubmit}>
        <div className="col-3" id="AddFormTitle">
        <Label>Title</Label>
            <Input
                value={Title} onChange={(e) =>setTitle(e.target.value)} placeholder="Udon"
                className="entry"
                bsSize="sm"
                maxLength="25"
                required
            />
        </div>

        <div className="col-8" id="AddFormDescription">
            <Label>Description</Label>
            <Input
                value={Desc} onChange={(e) =>setDesc(e.target.value)} placeholder="Noodles with beef and brooth"
                id="TextAreaPropDesc"
                className="entry"
                bsSize="sm"
                type="textarea"
                required
            />
        </div>

        <div className="col-8" id="AddFormIngredients">
            <Label>Ingredients</Label>
            <Input
                value={Ingred} onChange={(e) => setIngred(e.target.value)} placeholder="Noodles and Beef"
                id="TextAreaPropIng"
                className="entry"
                bsSize="sm"
                type="textarea"
                required
            />
        </div>

        <div className="col-2" id="FavoriteTag">
            <div>Favorite</div>
            <div className="d-flex gap-2">
                <label>
                    <input
                        type="radio"
                        name="Favorite"
                        value="true"
                        checked={Favorite === true}
                        onChange={handleOptionChange}
                    />
                    Yes
                </label>
                <label>
                    <input
                        type="radio"
                        name="Favorite"
                        value="false"
                        checked={Favorite === false}
                        onChange={handleOptionChange}
                    />
                    No
                </label>
            </div>
        </div>

        <div id="SubmitResetAdd">
            <button type="submit" className="Button">Submit</button>
            <button type="reset" className="Button">Reset</button>
        </div>
    </Form>
</div>
    )
}

export default NewRecipe;