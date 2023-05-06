const Shimmer = () => {
  return (
    <div>
      <div className="w-full  h-[60vh] flex-col  animate-pulse flex space-x-4 ">
        <div className="bg-gray-200 rounded-xl mt-10 h-3/4 mx-auto w-2/4"></div>
      </div>
      <div class="w-full  bg-white bg-opacity-50  rounded drop-shadow-lg flex justify-around items-center">
        <div className="h-[100px] m-5 w-[100px] bg-gray-400  rounded-full"></div>
        <div className="h-11 w-12 bg-gray-200"></div>
        <div className="h-11 w-12 bg-gray-200 "></div>
      </div>
    </div>
  );
};
export default Shimmer;
