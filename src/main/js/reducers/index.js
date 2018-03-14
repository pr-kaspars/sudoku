import { combineReducers } from 'redux';

const activeCell = (state = -1, action) => {
  switch (action.type) {
    case 'SET_ACTIVE_CELL':
      return action.index
    default:
      return state
  }
}

const cells = (state = [], action) => {
  switch (action.type) {
    case 'RECEIVE_PUZZLE':
      return action.puzzle.cells;
    case 'SET_CELL_VALUE':
      let j = {
        value: action.value,
        index: { value: action.index }
      };
      state = state.filter(e => e.index.value !== action.index);
      state.push(j);
      state.sort((a, b) => a.index.value - b.index.value);
      return state;
    default:
      return state;
  }
}

export default combineReducers({ activeCell, cells });
