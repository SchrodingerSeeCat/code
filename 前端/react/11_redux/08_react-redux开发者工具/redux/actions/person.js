import { ADD_PERSON } from '../constant'

// 创建添加人的action对象
export const createAddPersonAction = (person) => {
    return {
        type: ADD_PERSON,
        data: person
    }
}