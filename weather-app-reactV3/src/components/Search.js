const Search = ({ search, setSearch, setButtonClick, buttonClick }) => {
  return (
    <div className="w-full h-10 flex  justify-center items-center mt-10">
      <input
        type="text"
        placeholder="Search"
        className="text-center border border-black w-[80%] h-full text-xl rounded-2xl"
        value={search}
        onChange={(e) => {
          setSearch(e.target.value);
          console.log(search);
        }}
      />
      <button
        className="border border-white rounded-xl px-2 py-1 hover:bg-white hover:text-black  hover:transition-all mx-2 text-white"
        onClick={() => setButtonClick(!buttonClick)}
      >
        Search
      </button>
    </div>
  );
};

export default Search;
