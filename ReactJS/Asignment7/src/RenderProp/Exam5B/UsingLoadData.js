import React from 'react';
import LoadData from './LoadData';
import LinearWithValueLabel from './Icon'

class UsingLoadData extends React.Component {
    render() {
        return (
            <LoadData
                link="https://5fa3f6a7f10026001618e3ae.mockapi.io/api/v1/employees"
                render={({ list, isLoading }) => (
                    <div>
                        <h3>List member</h3>
                        {isLoading ? (
                            //icon dang load
                           <LinearWithValueLabel/>
                            ) : (
                                <ul>
                                    {list.map(user =>
                                        <li key={user.id}>{user.name}</li>
                                    )}
                                </ul>
                            )
                        }
                    </div>
                )}
            />
        )
    }
}
export default UsingLoadData;

