import _puzzle from './puzzle.json'

export default {
  getPuzzle: (cb, t) => cb(_puzzle) //setTimeout(() => cb(_puzzle), t || 0),
}
