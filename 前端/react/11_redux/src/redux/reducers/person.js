import { ADD_PERSON } from '../constant'

export default function personReducer(preState, action) { 
    const {type, data} = action

    switch(type){
        case ADD_PERSON:
            return [data, ...preState]     

        default:
            return []
    }
}