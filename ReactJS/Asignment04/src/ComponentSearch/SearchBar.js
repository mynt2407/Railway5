import React from 'react'

class SearchBar extends React.Component {
    render() {
        return (
           <form>
               <input type= "text" placeholder = "Search...."/>
               <br/>
               <input type = "checkbox">Only show products in stock </input>
           </form>
        )
    }
}
export default SearchBar;
