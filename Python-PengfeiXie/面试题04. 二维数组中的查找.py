class Solution:
    def binary_search(self, matrix, target, start, vertical):
        lo = start
        hi = len(matrix) - 1 if vertical else len(matrix[0]) - 1 # 垂直搜索：hi = 行数 - 1

        while lo <= hi:
            mid = (lo + hi) // 2
            if vertical:  # 垂直搜索
                if matrix[mid][start] < target:
                    lo = mid + 1
                elif matrix[mid][start] > target:
                    hi = mid - 1
                else: 
                    return True
            else:   # 水平搜索
                if matrix[start][mid] < target:
                    lo = mid + 1
                elif matrix[start][mid] > target:
                    hi = mid - 1
                else:
                    return True

        return False

    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix: return False   # 边界条件

        for i in range(min(len(matrix), len(matrix[0]))):
            vertical_found = self.binary_search(matrix, target, i, True) # 垂直方向是否找到
            horizontal_found = self.binary_search(matrix, target, i, False) # 水平是否找到
            if vertical_found or horizontal_found:  # 任一方向找到即可
                return True

        return False