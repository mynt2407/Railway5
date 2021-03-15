import { useFormik } from 'formik';
import React from 'react'

// Create empty context
const FormikContext = React.createContext({});

// Place all of what's returned by useFormik onto context
const Formik = ({ children, ...props }) => {
    const formikStateAndHelper = useFormik(props)
    return (
        <FormikContext.Provider value={formikStateAndHelper}>
            {typeof children === 'function'
                ? children(formikStateAndHelper) : children}
        </FormikContext.Provider>
    )
}
export default Formik;