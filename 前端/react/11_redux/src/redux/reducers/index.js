/**
 * 
 * 该文件用于汇总reducer
 */

// 引入combineReducers，用于合并多个reducer
import { combineReducers } from 'redux'

// 引入reducers
import count from './count'
import person from './person'

// 汇总reducers
export default combineReducers({
    count: count,
    persons: person
})