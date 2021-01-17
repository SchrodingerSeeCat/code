import { ADD_PERSON } from '../constant'

const initPersons = [{id: 12345, name: '老王', age: 34}]
export default function personReducer(preState = initPersons, action) { 
    const {type, data} = action

    switch(type){
        case ADD_PERSON:
            return [data, ...preState]     

        default:
            return preState
    }
}