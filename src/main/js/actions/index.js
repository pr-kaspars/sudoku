import service from '../service'

const receivePuzzle = puzzle => ({
  type: 'RECEIVE_PUZZLE',
  puzzle
})

const setActiveCell = index => ({
  type: 'SET_ACTIVE_CELL',
  index
})

const setCellValue = (index, value) => ({
  type: 'SET_CELL_VALUE',
  index, value
})

export const getPuzzle = () => dispatch =>
  service.getPuzzle(puzzle => dispatch(receivePuzzle(puzzle)))

export const selectCell = index =>
  dispatch => dispatch(setActiveCell(index))

export const updateCell = (index, value) =>
  dispatch => dispatch(setCellValue(index, value))
